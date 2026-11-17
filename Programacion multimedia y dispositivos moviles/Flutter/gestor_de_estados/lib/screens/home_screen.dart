import 'package:flutter/material.dart';
import 'package:gestor_de_estados/pages/pagina1.dart';
import 'package:gestor_de_estados/pages/pagina2.dart';
import 'package:gestor_de_estados/pages/pagina3.dart';

// 1. Primera clase: El Widget
class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

// 2. Segunda clase: El Estado (aquí va toda tu lógica y el build)
class _HomeScreenState extends State<HomeScreen> {
  final List<Widget> _paginas = [Pagina1(), Pagina2(), Pagina3()];
  int _paginaSeleccionada = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Gestor de estados'),
      ),
      body: _paginas[_paginaSeleccionada],
      bottomNavigationBar: BottomNavigationBar(
        onTap: (value) {
          setState(() {
            _paginaSeleccionada = value;
          });
        },
        currentIndex: _paginaSeleccionada,
        items: const [
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Pagina 1',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Pagina 2',
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.home),
            label: 'Pagina 3',
          ),
        ],
      ),
    );
  }
}
