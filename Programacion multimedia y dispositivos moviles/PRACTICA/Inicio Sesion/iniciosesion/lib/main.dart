import 'package:flutter/material.dart';
import 'package:iniciosesion/provider/login_provider.dart';
import 'package:provider/provider.dart';

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    // Leemos los datos guardados en el provider
    final login = context.watch<LoginProvider>();

    return Scaffold(
      appBar: AppBar(
        title: const Text('Home'),
        automaticallyImplyLeading: false,
      ),
      body: Padding(
        padding: const EdgeInsets.all(24),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text('Has introducido este email:'),
            Text(login.email, style: const TextStyle(fontSize: 22)),
            const SizedBox(height: 20),
            const Text('Has introducido esta contraseña:'),
            Text(login.password, style: const TextStyle(fontSize: 22)),
            const SizedBox(height: 40),
            SizedBox(
              width: double.infinity,
              child: ElevatedButton(
                onPressed: () {
                  Navigator.pop(context);
                },
                child: const Text('Volver al login'),
              ),
            ),
          ],
        ),
      ),
    );
  }
}