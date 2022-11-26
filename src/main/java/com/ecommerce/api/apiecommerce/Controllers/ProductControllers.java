package com.ecommerce.api.apiecommerce.Controllers;

import com.ecommerce.api.apiecommerce.Dtos.ProductDto;
import com.ecommerce.api.apiecommerce.Models.ProductModels;
import com.ecommerce.api.apiecommerce.Services.ProductServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/user-products")
public class ProductControllers {

    private static String caminhoImagens = "C:\\projetos\\ecommerce\\imagens";
    final ProductServices productServices;

    public ProductControllers(ProductServices productServices) {
        this.productServices = productServices;
    }

    @PostMapping("/T")
    private HttpEntity<MultiValueMap<String, Object>> getMultiValueMapHttpEntity(@RequestBody ProductDto productDto) throws JsonProcessingException {

        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        multiValueMap.add("Content-Type", "multipart/form-data");
        headers.addAll(multiValueMap);
        var productModels = new ProductModels();
        BeanUtils.copyProperties(productDto,productModels);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonInString = objectMapper.writeValueAsString(productDto);
        params.add("customerJson", jsonInString);
        final HttpEntity<MultiValueMap<String, Object>> requestEntity =
                new HttpEntity<>(new LinkedMultiValueMap<String, Object>(), headers);
        requestEntity.getBody().addAll(params);
        return requestEntity;
    }
    @PostMapping
    public ResponseEntity<Object> saveProducts(@RequestBody @Valid ProductDto productDto, @RequestParam (value = "file",required = false)MultipartFile arquivo){
        if (productServices.existsByNomeTipo(productDto.getNomeProduto())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Conflict: This product already been created!");
        }

        var productModels = new ProductModels();
        BeanUtils.copyProperties(productDto,productModels);

        try {
            if (!arquivo.isEmpty()){
                byte[] bytes = arquivo.getBytes();
                Path caminho = Paths.get(caminhoImagens+String.valueOf(productModels.getId())+arquivo.getOriginalFilename());
                Files.write(caminho, bytes);

                productModels.setNomeImagem1(String.valueOf(productModels.getId())+arquivo.getOriginalFilename());
            }
        }catch(IOException e){
            e.printStackTrace();
        }


        System.err.println(productDto +"\n" + productModels);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productServices.save(productModels));
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping
    public ResponseEntity<Page<ProductModels>> getAllProducts(@PageableDefault(
            page = 0,size = 10,sort = "id",direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(productServices.findAll(pageable));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable(value = "id") long id){
        Optional<ProductModels> productModels = productServices.findByid(id);
        return productModels.<ResponseEntity<Object>>map(typeModels -> ResponseEntity.status(HttpStatus.OK).body(typeModels)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("username not found"));
    }


}
