import 'dart:math';

import 'package:flutter/material.dart';

class AnimatedScreen extends StatefulWidget {
   
  const AnimatedScreen({super.key});

  @override
  State<AnimatedScreen> createState() => _AnimatedScreenState();
}



class _AnimatedScreenState extends State<AnimatedScreen> {

  double _width = 50;
  double _heigth = 50;
  BorderRadiusGeometry _radio = BorderRadius.circular(10);
  Color _color = Colors.indigo;

  void cambiarShape(){
  final random = Random();
  _width = random.nextInt(300).toDouble() + 70;
  _heigth = random.nextInt(300).toDouble() + 70;
  _radio = BorderRadius.circular(random.nextInt(100).toDouble() + 10);
  _color = Color.fromRGBO(random.nextInt(255), random.nextInt(255), random.nextInt(255), 1);
  setState(() {
    
  });
}

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar( title: Text('SnackBar'),),
      body: Center(
         child: Container(
          width: _width,
          height: _heigth,
          decoration: BoxDecoration(
            color: _color,
            borderRadius: _radio,
          ),
          child: AnimatedContainer(
            duration: Duration(milliseconds: 2000),
            curve: Curves.easeInOutCubic,
          ),
         ),
      ),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.play_circle_outline_outlined),
        onPressed: ()=>cambiarShape(),
      ),
    );
  }
}