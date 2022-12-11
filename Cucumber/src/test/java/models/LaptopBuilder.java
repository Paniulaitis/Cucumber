package models;

import models.valueobjects.Company;
import models.valueobjects.Ram;

// Класс строитель объекта "Смартфон"
public class LaptopBuilder {
    // Оперативная память
    private Ram ram;
    // Внутренняя память
    private int rom = 256; // значение заданное по умолчанию - 256
    // Производитель
    private Company сompany;
    // Модель
    private String model = "Asus ROG"; // значение заданное по умолчанию

    // Конструктор
    public LaptopBuilder(Ram ram, Company сompany) {
        this.ram = ram;
        this.сompany = сompany;
    }

    // Установка значения поля "Внутренняя память"
    public LaptopBuilder setRom(int rom) {
        this.rom = rom;
        return this;
    }

    // Установка значения поля "Модель"
    public LaptopBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    // Создание объекта "Ноутбук"
    public Laptop build() {
        Laptop laptop = new Laptop();
        laptop.setRam(this.ram);
        laptop.setRom(this.rom);
        laptop.setCompany(this.сompany);
        laptop.setModel(this.model);
        return laptop;
    }
}