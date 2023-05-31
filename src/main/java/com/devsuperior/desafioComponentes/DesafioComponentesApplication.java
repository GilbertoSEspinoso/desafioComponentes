package com.devsuperior.desafioComponentes;

import com.devsuperior.desafioComponentes.entities.Order;
import com.devsuperior.desafioComponentes.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioComponentesApplication implements CommandLineRunner {

    @Autowired
    OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(DesafioComponentesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("ENTRE COM OS DADOS DO PEDIDO");
        System.out.print("Número do pedido: ");
        int code = sc.nextInt();
        System.out.print("Valor básico: ");
        double basic = sc.nextDouble();
        System.out.print("Valor do desconto: ");
        double discount = sc.nextDouble();

        Order order = new Order(code, basic, discount);

        System.out.println();
        System.out.printf("Pedido código " + code + "%nValor total: R$ %.2f", orderService.total(order));

        sc.close();
    }
}
