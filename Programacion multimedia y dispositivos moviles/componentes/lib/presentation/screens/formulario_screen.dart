import 'package:componentes/presentation/widgets/custo_input_field.dart';
import 'package:flutter/material.dart';

class FormularioScreen extends StatelessWidget {

  final String? hintText;
  final String? labelText;
  final String? helpderText;
  final IconData? icon;
  final IconData? suffixIcon;

  const new({super.key, this.hintText, this.labelText, this.helpderText, this.icon, this.suffixIcon});

  
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Formulario')),
      body: SingleChildScrollView(
        child: Padding(
          padding: EdgeInsetsGeometry.symmetric(horizontal: 20, vertical: 10),
          child: Column(
            children: [
              CustomInputField(),
              CustomInputField(),
              CustomInputField(),
              CustomInputField(),
              CustomInputField(),
              CustomInputField()
            ],
          ),
        ),
      )
    );
  }

  
}