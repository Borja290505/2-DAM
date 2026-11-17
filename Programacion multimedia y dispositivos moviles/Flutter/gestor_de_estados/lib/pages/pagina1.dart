import 'package:flutter/material.dart';

class Pagina1 extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.lightBlueAccent,
      body: Column(
        children: [
          Text('Esto es un StateFull'),
          Text('Pagina 1',style: TextStyle(fontSize: 120),)
        ],
         
      ),
      
    );
    
  }
}