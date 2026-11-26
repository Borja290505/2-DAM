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
            const Text('Email'),
            const SizedBox(height: 8),
            Text(login.email, style: const TextStyle(fontSize: 20)),
            const SizedBox(height: 24),
            const Text('Contraseña'),
            const SizedBox(height: 8),
            Text(login.password, style: const TextStyle(fontSize: 20)),
            const SizedBox(height: 24),
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