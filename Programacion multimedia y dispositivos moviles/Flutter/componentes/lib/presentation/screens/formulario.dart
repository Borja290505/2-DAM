import 'package:componentes/presentation/Widgets/custom_input_field.dart';
import 'package:flutter/material.dart';

class FormularioScreen extends StatelessWidget {
  const FormularioScreen({super.key});

  @override
  Widget build(BuildContext context) {
    //GlobalKey nos permite controlar y validar el formulario completo
    final GlobalKey<FormState> _formKey = GlobalKey<FormState>();

    final Map<String, String> formValues = {
      'first-name': 'Borja',
      'last-name': 'Ros',
      'email': 'Borja@iesch.org',
      'password': '1234',
      'role': 'Developer',
      'tfno': '684382676',
    };

    return Scaffold(
      appBar: AppBar(
        title: Text("Formularios"),
        titleTextStyle: TextStyle(color: Colors.white, fontSize: 30),
        backgroundColor: Colors.blue,
        iconTheme: IconThemeData(color: Colors.white),
      ),
      body: SingleChildScrollView(
        child: Padding(
          padding: EdgeInsetsGeometry.symmetric(horizontal: 20, vertical: 10),
          child: Form(
            child: Column(
              children: [
                CampoDeTextoPersonalizado(
                  coutText: "Contador",
                  hintText: "Rellena esto",
                  labelText: "Nombre",
                  helperText: "Sólo letras",
                  prefixIcon: Icon(Icons.abc_sharp),
                  sufixIcon: Icon(Icons.mediation_sharp),
                  icon: Icon(Icons.one_k_plus_outlined),
                  formValues: formValues,
                  formProperty: 'first-name',
                ),
                CampoDeTextoPersonalizado(
                  coutText: "Contador",
                  hintText: "Rellena esto",
                  labelText: "Apellidos",
                  helperText: "Sólo letras",
                  prefixIcon: Icon(Icons.abc_sharp),
                  sufixIcon: Icon(Icons.mediation_sharp),
                  icon: Icon(Icons.one_k_plus_outlined),
                  formValues: formValues,
                  formProperty: 'last-name',
                ),
                CampoDeTextoPersonalizado(
                  coutText: "Contador",
                  hintText: "Rellena esto también",
                  labelText: "Email",
                  helperText: "Sólo letras",
                  icon: Icon(Icons.one_k_plus_outlined),
                  keyboardType: .emailAddress,
                  formValues: formValues,
                  formProperty: 'email',
                ),
                CampoDeTextoPersonalizado(
                  coutText: "Contador",
                  hintText: "Y esto",
                  labelText: "Telefono",
                  helperText: "Tu telefono",
                  icon: Icon(Icons.one_k_plus_outlined),
                  keyboardType: .phone,
                  formValues: formValues,
                  formProperty: 'tfno',
                ),
                CampoDeTextoPersonalizado(
                  coutText: "Contador",
                  hintText: "También esto",
                  labelText: "Contraseña",
                  helperText: "Tu contraseña",
                  icon: Icon(Icons.one_k_plus_outlined),
                  keyboardType: .visiblePassword,
                  formValues: formValues,
                  formProperty: 'password',
                ),
                SizedBox(height: 20),
                DropdownButtonFormField(
                  initialValue: "admin",
                  items: [
                    DropdownMenuItem(child: Text("Admin"), value: "admin"),
                    DropdownMenuItem(child: Text("Super user"), value: "sUser"),
                    DropdownMenuItem(
                      child: Text("Developper"),
                      value: "developper",
                    ),
                  ],
                  onChanged: (value){
                    formValues['role'] = value ?? 'Developer';
                  },
                ),
                SizedBox(height: 20),
                ElevatedButton(
                  onPressed: () => print(formValues),
                  child: Text('Guardar'),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
