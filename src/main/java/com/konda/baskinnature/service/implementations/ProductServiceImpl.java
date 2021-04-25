package com.konda.baskinnature.service.implementations;

import com.github.slugify.Slugify;
import com.konda.baskinnature.model.Category;
import com.konda.baskinnature.model.Product;
import com.konda.baskinnature.repository.CategoryRepository;
import com.konda.baskinnature.repository.ProductRepository;
import com.konda.baskinnature.service.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    Slugify slg = new Slugify();

    @Override
    public Product addProduct(Product product) {
        Category category = categoryRepository.findById(product.getCategoryId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Category with provided ID : %s", product.getCategoryId())));
        product.setGenre(category.getName());
        product.setSlug(slg.slugify(product.getTitle()));
        return productRepository.insert(product);
    }

    @Override
    public List<Product> addProducts(List<Product> products) {
        for (Product p : products
        ) {
            Category category = categoryRepository.findById(p.getCategoryId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Category with provided ID : %s", p.getCategoryId())));
            p.setGenre(category.getName());
            p.setSlug(slg.slugify(p.getTitle()));

        }
        return productRepository.insert(products);
    }

    @Override
    public Product updateProduct(Product product, String id) {
        Product oldProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Category with provided ID : %s", product.getId())));
        oldProduct.setTitle(product.getTitle());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setVariants(product.getVariants());
        oldProduct.setTypes(product.getTypes());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setImage(product.getImage());
        oldProduct.setPublished(product.getPublished());
        oldProduct.setFeatured(product.getFeatured());
        oldProduct.setStockInUnits(product.getStockInUnits());
        oldProduct.setSlug(slg.slugify(product.getTitle()));

        return productRepository.save(oldProduct);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("invalid id"));

    }

    @Override
    public Product getProductBySlug(String slug) {
        return productRepository.findProductBySlug(slug);
    }

    @Override
    public String deleteProduct(String id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Category with provided ID : %s", id)));
        productRepository.delete(product);
        return "Product with id" + id + " deleted successfully";
    }

    @Override
    public String deleteAllProduct() {
        productRepository.deleteAll();
        return "Success";
    }
}
