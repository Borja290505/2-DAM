import 'package:flutter/material.dart';

class Practica8Screen extends StatefulWidget {
  const Practica8Screen({super.key});

  @override
  State<Practica8Screen> createState() => _Practica8ScreenState();
}

class _Practica8ScreenState extends State<Practica8Screen> {
  List<String> _tareas = _tareasIniciales();

  static List<String> _tareasIniciales() =>
      List.generate(10, (i) => 'Tarea ${i + 1}');

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Práctica 3 - Dismissible'),
        actions: [
          IconButton(
            tooltip: 'Restaurar lista',
            icon: const Icon(Icons.refresh),
            onPressed: () => setState(() => _tareas = _tareasIniciales()),
          ),
        ],
      ),
      body: Column(
        children: [
          Expanded(
            child: _tareas.isEmpty ? const Center(child: Text('No quedan tareas '))
                : ListView.builder(
                    itemCount: _tareas.length,
                    itemBuilder: (context, index) {
                      final tarea = _tareas[index];

                      return Dismissible(
                        // La key identifica el elemento: debe ser única
                        key: ValueKey(tarea),

                        // Permitimos ambas direcciones (es el valor por defecto)
                        direction: DismissDirection.horizontal,

                        // Hay que deslizar al menos el 40% para descartar
                        dismissThresholds: const {
                          DismissDirection.startToEnd: 0.4,
                          DismissDirection.endToStart: 0.4,
                        },

                        // Fondo al deslizar hacia la derecha -> Archivar
                        background: _fondo(
                          color: Colors.green,
                          icono: Icons.archive,
                          texto: 'Archivar',
                          alineacion: Alignment.centerLeft,
                        ),

                        // Fondo al deslizar hacia la izquierda -> Eliminar
                        secondaryBackground: _fondo(
                          color: Colors.red,
                          icono: Icons.delete,
                          texto: 'Eliminar',
                          alineacion: Alignment.centerRight,
                        ),

                        // Solo pedimos confirmación al eliminar
                        confirmDismiss: (direction) async {
                          if (direction == DismissDirection.endToStart) {
                            return await _confirmarBorrado(tarea);
                          }
                          return true;
                        },

                        // Se ejecuta cuando el elemento ya ha desaparecido
                        onDismissed: (direction) {
                          final archivada =
                              direction == DismissDirection.startToEnd;

                          setState(() => _tareas.removeAt(index));

                          ScaffoldMessenger.of(context)
                            ..hideCurrentSnackBar()
                            ..showSnackBar(
                              SnackBar(
                                content: Text(
                                  '$tarea ${archivada ? 'archivada' : 'eliminada'}',
                                ),
                                action: SnackBarAction(
                                  label: 'Deshacer',
                                  onPressed: () => setState(
                                    () => _tareas.insert(index, tarea),
                                  ),
                                ),
                              ),
                            );
                        },

                        child: Card(
                          margin: const EdgeInsets.symmetric(
                              horizontal: 12, vertical: 4),
                          child: ListTile(
                            leading: CircleAvatar(child: Text('${index + 1}')),
                            title: Text(tarea),
                            subtitle: const Text('Desliza para ver opciones'),
                            trailing: const Icon(Icons.swipe),
                          ),
                        ),
                      );
                    },
                  ),
          ),
        ],
      ),
    );
  }

  /// Fondo coloreado que aparece detrás del elemento al deslizarlo
  Widget _fondo({
    required Color color,
    required IconData icono,
    required String texto,
    required Alignment alineacion,
  }) {
    final esIzquierda = alineacion == Alignment.centerLeft;
    final contenido = [
      Icon(icono, color: Colors.white),
      const SizedBox(width: 8),
      Text(texto,
          style: const TextStyle(
              color: Colors.white, fontWeight: FontWeight.bold)),
    ];

    return Container(
      color: color,
      alignment: alineacion,
      padding: const EdgeInsets.symmetric(horizontal: 20),
      child: Row(
        mainAxisSize: MainAxisSize.min,
        children: esIzquierda ? contenido : contenido.reversed.toList(),
      ),
    );
  }

  /// Diálogo de confirmación: devuelve true si el usuario acepta
  Future<bool> _confirmarBorrado(String tarea) async {
    final resultado = await showDialog<bool>(
      context: context,
      builder: (context) => AlertDialog(
        title: const Text('Eliminar'),
        content: Text('¿Seguro que quieres eliminar "$tarea"?'),
        actions: [
          TextButton(
            onPressed: () => Navigator.pop(context, false),
            child: const Text('Cancelar'),
          ),
          FilledButton(
            onPressed: () => Navigator.pop(context, true),
            child: const Text('Eliminar'),
          ),
        ],
      ),
    );
    return resultado ?? false; // Si cierra el diálogo tocando fuera -> false
  }
}
