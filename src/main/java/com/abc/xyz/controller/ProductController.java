package com.abc.xyz.controller;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abc.xyz.entity.Category;
import com.abc.xyz.entity.Product;
import com.abc.xyz.repository.ProductRepository;
import com.abc.xyz.service.CategoryService;
import com.abc.xyz.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	ProductRepository productRepository;
	@RequestMapping(value = "/product_all")
    public List<Product> product() {
        return productService.getAll();
    }
 
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Product createProduct(@Valid @RequestParam Product product)
    {
        return productService.createProduct(product);
    }
    
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Optional<Product> deteilProduct(@PathVariable(value = "id") int id)
    {
        return productService.detailProduct(id);
    }
    
    @PostMapping("/fileupload")
    public String fileUpload(
    		@RequestParam("category_id") int CATEGORY_ID,
    		@RequestParam("description") String description,
    		@RequestParam("name_product") String name_product,
    		@RequestParam("price") float price, 
    		@RequestParam("product_code") String product_code
    		) {
        try {
//            logger.info("Name= " + name);
//            byte[] image = xxx.getBytes();
//            Product model = new Product(CATEGORY_ID, description, compressBytes(xxx.getBytes()), name_product, price, product_code, 
//            		xxx.getContentType(), xxx.getOriginalFilename());
        	
//            Product model = new Product(CATEGORY_ID, description, name_product, price, product_code);
        	Product model = new Product(CATEGORY_ID, description, name_product, price, product_code);
            int saveImage = productService.saveImage(model);
            if (saveImage == 1) {
                return "success";
            } else {
                return "error";
            }
        } catch (Exception e) {
//            logger.error("ERROR", e);
            return "error";
        }
    }
    
//    @GetMapping(path = { "/get/{imageName}" })
    @RequestMapping(value = "/image/{imageName}", method = RequestMethod.GET)
    public Product getImage(@PathVariable(value = "imageName") String imageName) throws IOException {
        Optional<Product> retrievedImage = productRepository.findByName("ionic");
        Product img = new Product(retrievedImage.get().getName(), retrievedImage.get().getType(),
        decompressBytes(retrievedImage.get().getImage()));
        return img;
    }
    
    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
        	int count = deflater.deflate(buffer);
        	 outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }
    
 // uncompress the image bytes before returning it to the angular application
    
        public static byte[] decompressBytes(byte[] data) {
    
            Inflater inflater = new Inflater();
    
            inflater.setInput(data);
    
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    
            byte[] buffer = new byte[1024];
    
            try {
    
                while (!inflater.finished()) {
    
                    int count = inflater.inflate(buffer);
    
                    outputStream.write(buffer, 0, count);
    
                }
    
                outputStream.close();
    
            } catch (IOException ioe) {
    
            } catch (DataFormatException e) {
    
            }
   
            return outputStream.toByteArray();
    
        }
    
    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") int id) 
    {
        return productService.deleteProduct(id);
    }
 
    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public Product updateProduct(@PathVariable(value = "id") int id, @Valid @RequestBody Product product) 
    {
        return productService.updateProduct(id, product);
    }

}
