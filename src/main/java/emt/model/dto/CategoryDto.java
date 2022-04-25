package emt.model.dto;


import lombok.Data;

@Data
public class CategoryDto {
    private String category;
    private Integer count;

    public CategoryDto(String category, Integer count) {
        this.category = category;
        this.count = count;
    }

    public CategoryDto() {
    }
}