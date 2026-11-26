import 'package:api_rest_1/models/user.dart'; // ¡No olvides importar tu modelo User!
import 'package:api_rest_1/services/user_service.dart';
import 'package:flutter/material.dart';

class UsersScreen extends StatefulWidget {
  const UsersScreen({super.key});

  @override
  State<UsersScreen> createState() => _UsersScreenState();
}

class _UsersScreenState extends State<UsersScreen> {
  // Es mejor tipar el Future como Future<List<User>> si tu servicio devuelve Users
  late Future<List<dynamic>> _futureUsers;

  @override
  void initState() {
    super.initState();
    _futureUsers = UserService().obtenerUsuarioConDio();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Lista de usuarios')),
      body: FutureBuilder(
        future: _futureUsers,
        // Usamos llaves { } en lugar de => (
        builder: (context, snapshot) {
          if (snapshot.connectionState == ConnectionState.waiting) {
            return const Center(child: CircularProgressIndicator.adaptive());
          } else if (snapshot.hasError) { // Sin guion en else if
            return Center(child: Text('Error: ${snapshot.error}')); // $ dentro de las comillas
          } else {
            final listaUsuarios = snapshot.data!;
            return ListView.builder(
              itemCount: listaUsuarios.length,
              // Quitamos la palabra repetida "itemBuilder"
              itemBuilder: (context, index) {
                final User usuario = listaUsuarios[index]; // Añadido ;
                return ListTile(
                  title: Text(usuario.name),
                  subtitle: Text(usuario.email), // Opcional: muestra más datos
                ); // Añadido ;
              },
            ); // Añadido ;
          }
        }, // Añadida llave de cierre del builder
      ),
    );
  }
}
