package com.website.backendone.dev;

import com.website.backendone.entity.Category;
import com.website.backendone.entity.Product;
import com.website.backendone.entity.Section;
import com.website.backendone.repository.CategoryRepository;
import com.website.backendone.repository.ProductRepository;
import com.website.backendone.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevService {
    private final SectionRepository sectionRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public DevService(
            CategoryRepository categoryRepository,
            ProductRepository productRepository,
            SectionRepository sectionRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.sectionRepository = sectionRepository;
    }

    public boolean resetDatabase() {
        try {
            categoryRepository.deleteAll();
            productRepository.deleteAll();
            sectionRepository.deleteAll();

//        User user = new User();
//        user.setUserName("Subhadeep Chakraborty");
//        user.setEmail("user1@gmail.com");
//        user.setPassword(PasswordEncryptor.encrypt("pass"));
//        userRepository.save(user);

            Section section;
            for (String[] data : DatabaseBackup.sectionData) {
                section = new Section();
                section.setName(data[0]);
                sectionRepository.save(section);
            }

            Category category;
            for (String[] data : DatabaseBackup.categoryData) {
                section = new Section();
                section.setId(Integer.parseInt(data[0]));
                category = new Category();
                category.setName(data[1]);
                category.setSection(section);
                category.setImageUrl(data[2]);
                categoryRepository.save(category);
            }

            Product product;
            String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed nunc tortor. Sed tellus nunc, fringilla a tristique et, egestas in ex. Ut ut dui sit amet enim ornare posuere a vel justo. Morbi lorem purus, vulputate ut maximus id, pretium eget sem. Vestibulum sit amet pretium lectus. Mauris non lorem erat. Mauris et nulla eget metus maximus consequat. Ut eget ligula at velit porta posuere non quis neque. Donec dignissim ornare egestas. Quisque id libero finibus, sagittis arcu id, ultrices mauris. Sed pellentesque vulputate velit ut tempor. Nunc a lectus bibendum lectus sollicitudin posuere. Sed ultrices eu nisl vel ullamcorper. Aliquam scelerisque luctus odio sollicitudin posuere.";
            for (int i = 0; i < DatabaseBackup.productData.length; i++) {
                String[] data = DatabaseBackup.productData[i];
                category = new Category();
                category.setId(Integer.parseInt(data[0]));
                product = new Product();
                product.setName(data[1]);
                product.setImageUrl(data[2]);
                product.setCategory(category);
                data = DatabaseBackup.productPriceData[i];
                product.setMarkedPrice(Integer.parseInt(data[0]));
                product.setSellingPrice(Integer.parseInt(data[1]));
                product.setDescription(description);
                product.setReviewCount(0);
                product.setTotalRating(0);
                productRepository.save(product);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
