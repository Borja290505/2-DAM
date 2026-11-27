package Ejercicio10_CSV;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static void main(String[] args) {
        List<Producto> listaProductos = new ArrayList<>();
        try (Stream<String> lineas = Files.lines(Path.of("src/main/java/Ejercicio10_CSV/products.csv"))){

            listaProductos = lineas.skip(1).map(l ->l.split(",")).map(c -> new Producto(Long.parseLong(c[0]),c[1], Long.parseLong(c[2]),Long.parseLong(c[3]),c[4],Double.parseDouble(c[5]),Long.parseLong(c[6]),Long.parseLong(c[7]),Long.parseLong(c[8]),Integer.parseInt(c[9]))).toList();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Imprimir la lista completa
        System.out.println("-- MOSTRAMOS TODA LA LISTA");
        for (Producto p : listaProductos){
            System.out.println(p);
        }

        //Imprimir solo los nombres
        System.out.println("-- MOSTRAMOS SOLO LOS NOMBRES --");
        listaProductos.stream().map(Producto::getProductName).forEach(System.out::println);


        System.out.println("-- PRODUCTOS CON STOCK MENOR QUE 10 --");
        listaProductos.stream().filter(l-> l.unitsInStock < 10).forEach(System.out::println);

        System.out.println("-- PRODUCTOS CON STOCK MENOR QUE 10 --");
        listaProductos.stream().filter(l-> l.unitsInStock < 10).sorted(Comparator.comparing(Producto::getUnitsInStock).reversed()).map(Producto::getProductName).forEach(System.out::println);


        System.out.println("-- NUMERO DE PRODUCTOS POR PROVEEDOR --");
        Map<Long, Long> porProveedor = listaProductos.stream().collect(Collectors.groupingBy(Producto::getSupplierID,  Collectors.counting()));
        porProveedor.forEach((supplierId, cantidad) ->
                System.out.println("Proveedor: " + supplierId + " total: " + cantidad)
        );

        System.out.println("-- SUMA PRECIO UNITARIO AGRUPADA EN STOCK CUYA SUMA SE MAYOR 100 --");
        listaProductos.stream().collect(Collectors.groupingBy(Producto::getUnitsInStock, Collectors.summingDouble(Producto::getUnitPrice))).entrySet().stream().filter(e-> e.getValue() > 100).forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));

        System.out.println("-- MEDIA DE STOCK --");
        double mediaStock = listaProductos.stream().mapToLong(Producto::getUnitsInStock).average().orElse(0);
        System.out.println("Hay una media de: " + mediaStock);

        System.out.println("-- PRODUCTO MAS CARO --");
        listaProductos.stream().max(Comparator.comparing(Producto::getUnitPrice)).ifPresent(System.out::println);

        System.out.println("-- SOLO 50 PRODUCTOS --");
        listaProductos.stream().limit(50).forEach(System.out::println);


    }
}
