import 'package:flutter/material.dart';

// =====================================================================
//  PRÁCTICA 3 - PARTE 1: Navegación en Flutter (5 pantallas)
// =====================================================================
//
//  Mapa de navegación:
//    Pantalla 1 -> 3, 4
//    Pantalla 2 -> 5
//    Pantalla 3 -> 1, 2
//    Pantalla 4 -> 3, 5
//    Pantalla 5 -> 1, 2, 4  + "Volver al inicio" (vacía la pila)
// =====================================================================

void main() => runApp(const MyApp());

// Colores de cada pantalla (AppBar + botones)
const Color colorPantalla1 = Colors.blue;
const Color colorPantalla2 = Colors.green;
const Color colorPantalla3 = Colors.orange;
const Color colorPantalla4 = Colors.purple;
const Color colorPantalla5 = Colors.red;

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Práctica 3 - Navegación',
      // La app se inicia en la pantalla 1
      initialRoute: '/pantalla1',
      routes: {
        '/pantalla1': (context) => const Pantalla1(),
        '/pantalla2': (context) => const Pantalla2(),
        '/pantalla3': (context) => const Pantalla3(),
        '/pantalla4': (context) => const Pantalla4(),
        '/pantalla5': (context) => const Pantalla5(),
      },
    );
  }
}

// ---------------------------------------------------------------------
//  PANTALLAS
// ---------------------------------------------------------------------

class Pantalla1 extends StatelessWidget {
  const Pantalla1({super.key});

  @override
  Widget build(BuildContext context) {
    return PlantillaPantalla(
      numero: 1,
      color: colorPantalla1,
      botones: [
        BotonNavegar(texto: 'Ir a Pantalla 3', color: colorPantalla1, ruta: '/pantalla3'),
        BotonNavegar(texto: 'Ir a Pantalla 4', color: colorPantalla1, ruta: '/pantalla4'),
      ],
    );
  }
}

class Pantalla2 extends StatelessWidget {
  const Pantalla2({super.key});

  @override
  Widget build(BuildContext context) {
    return PlantillaPantalla(
      numero: 2,
      color: colorPantalla2,
      botones: [
        BotonNavegar(texto: 'Ir a Pantalla 5', color: colorPantalla2, ruta: '/pantalla5'),
      ],
    );
  }
}

class Pantalla3 extends StatelessWidget {
  const Pantalla3({super.key});

  @override
  Widget build(BuildContext context) {
    return PlantillaPantalla(
      numero: 3,
      color: colorPantalla3,
      botones: [
        BotonNavegar(texto: 'Ir a Pantalla 1', color: colorPantalla3, ruta: '/pantalla1'),
        BotonNavegar(texto: 'Ir a Pantalla 2', color: colorPantalla3, ruta: '/pantalla2'),
      ],
    );
  }
}

class Pantalla4 extends StatelessWidget {
  const Pantalla4({super.key});

  @override
  Widget build(BuildContext context) {
    return PlantillaPantalla(
      numero: 4,
      color: colorPantalla4,
      botones: [
        BotonNavegar(texto: 'Ir a Pantalla 3', color: colorPantalla4, ruta: '/pantalla3'),
        BotonNavegar(texto: 'Ir a Pantalla 5', color: colorPantalla4, ruta: '/pantalla5'),
      ],
    );
  }
}

class Pantalla5 extends StatelessWidget {
  const Pantalla5({super.key});

  @override
  Widget build(BuildContext context) {
    return PlantillaPantalla(
      numero: 5,
      color: colorPantalla5,
      botones: [
        BotonNavegar(texto: 'Ir a Pantalla 1', color: colorPantalla5, ruta: '/pantalla1'),
        BotonNavegar(texto: 'Ir a Pantalla 2', color: colorPantalla5, ruta: '/pantalla2'),
        BotonNavegar(texto: 'Ir a Pantalla 4', color: colorPantalla5, ruta: '/pantalla4'),
        const SizedBox(height: 24),
        // Elimina todas las pantallas de la pila y vuelve a la inicial
        Padding(
          padding: const EdgeInsets.symmetric(vertical: 8),
          child: OutlinedButton.icon(
            style: OutlinedButton.styleFrom(
              foregroundColor: colorPantalla5,
              side: const BorderSide(color: colorPantalla5, width: 2),
              minimumSize: const Size(240, 50),
            ),
            icon: const Icon(Icons.home),
            label: const Text('Volver al inicio'),
            onPressed: () {
              // Quita de la pila todas las rutas hasta llegar a la primera
              Navigator.popUntil(context, (route) => route.isFirst);
            },
          ),
        ),
      ],
    );
  }
}

// ---------------------------------------------------------------------
//  WIDGETS REUTILIZABLES
// ---------------------------------------------------------------------

/// Estructura común: AppBar con el título "Pantalla X" y su color,
/// número grande en el centro y la lista de botones debajo.
class PlantillaPantalla extends StatelessWidget {
  final int numero;
  final Color color;
  final List<Widget> botones;

  const PlantillaPantalla({
    super.key,
    required this.numero,
    required this.color,
    required this.botones,
  });

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Pantalla $numero'),
        backgroundColor: color,
        foregroundColor: Colors.white,
        centerTitle: true,
      ),
      body: Center(
        child: SingleChildScrollView(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text(
                '$numero',
                style: TextStyle(
                  fontSize: 120,
                  fontWeight: FontWeight.bold,
                  color: color,
                ),
              ),
              const SizedBox(height: 24),
              ...botones,
            ],
          ),
        ),
      ),
    );
  }
}

/// Botón que navega a una ruta con nombre (push -> se apila).
class BotonNavegar extends StatelessWidget {
  final String texto;
  final Color color;
  final String ruta;

  const BotonNavegar({
    super.key,
    required this.texto,
    required this.color,
    required this.ruta,
  });

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 8),
      child: ElevatedButton.icon(
        style: ElevatedButton.styleFrom(
          backgroundColor: color,
          foregroundColor: Colors.white,
          minimumSize: const Size(240, 50),
        ),
        icon: const Icon(Icons.arrow_forward),
        label: Text(texto),
        onPressed: () => Navigator.pushNamed(context, ruta),
      ),
    );
  }
}