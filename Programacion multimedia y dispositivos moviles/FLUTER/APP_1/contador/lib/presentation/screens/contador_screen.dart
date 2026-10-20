import 'package:flutter/material.dart';
class ContadorScreen extends StatefulWidget {
  const ContadorScreen({super.key});

  @override
  State<ContadorScreen> createState() => _ContadorScreenState();
}

class _ContadorScreenState extends State<ContadorScreen> {
  int contador = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Contador App'), centerTitle: true),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              '$contador',
              style: const TextStyle(fontSize: 160, fontWeight: FontWeight.w100),
            ),
            const Text('Clicks', style: TextStyle(fontSize: 25)),
          ],
        ),
      ),
      floatingActionButton: Row(
        mainAxisAlignment: MainAxisAlignment.end,
        children: [
          FloatingActionButton(
            heroTag: 'btn1', // Evita conflictos si hay múltiples botones de acción
            child: const Icon(Icons.remove),
            onPressed: () {
              contador--;
              setState(() {});
            },
          ),
          const SizedBox(width: 10),
          FloatingActionButton(
            heroTag: 'btn2', 
            child: const Icon(Icons.add),
            onPressed: () {
              contador++;
              setState(() {});
            },
          ),
        ],
      ),
    );
  }
}