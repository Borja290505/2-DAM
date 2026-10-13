import 'package:flutter/material.dart';
import 'package:contador/'

class ContadorScreen extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: ContadorScreen()
    );
  }
}