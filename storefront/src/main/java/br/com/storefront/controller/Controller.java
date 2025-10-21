package br.com.storefront.controller;

import br.com.storefront.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${warehouse.api.url}")
    private String warehouseApiUrl;

    @GetMapping("/")
    public String home(Model model) {
        try {
            // Chama a API do warehouse para obter a lista de produtos
            // Chama a API do warehouse para obter a lista de produtos
            ProductDTO[] produtosArray = restTemplate.getForObject(warehouseApiUrl, ProductDTO[].class);
            List<ProductDTO> produtos = produtosArray != null ? Arrays.asList(produtosArray) : List.of();
            model.addAttribute("produtos", produtos);
        } catch (Exception e) {
            // Em caso de erro (ex: serviço warehouse offline), passa uma lista vazia
            model.addAttribute("produtos", List.of());
            model.addAttribute("erro", "Não foi possível conectar ao serviço de armazém.");
        }
        return "index"; // Retorna o nome do arquivo HTML (index.html)
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/produto/{id}")
    public String productDetails(@PathVariable Long id, Model model) {
        try {
            String url = warehouseApiUrl + "/" + id;
            ProductDTO produto = restTemplate.getForObject(url, ProductDTO.class);
            model.addAttribute("produto", produto);
        } catch (Exception e) {
            model.addAttribute("erro", "Não foi possível encontrar o produto ou o serviço de armazém está indisponível.");
        }
        return "detalhes";
    }
}
