
import 'package:componentes/models/menu_option.dart';
import 'package:flutter/material.dart';

// ignore: camel_case_types
class HomeScreen extends StatelessWidget {
   
  const HomeScreen({super.key});
  
  @override
  Widget build(BuildContext context) {

     final menuOptions = <menuOption>[
      menuOption(ruta: "listView1",icono: Icons.list_alt, nombre: "ListView Tipo 1"),
      menuOption(ruta: "listView2",icono: Icons.list, nombre: "ListView Tipo 2"),
      menuOption(ruta: "alert",icono: Icons.add_alert, nombre: "Alertas - Alerts"),
      menuOption(ruta: "card",icono: Icons.credit_card, nombre: "Tarjetas - Cards")
    ];


    return Scaffold(
      appBar: AppBar(
        title: Text('Componentes en flutter'),
      ),
      body: ListView.separated(
         itemBuilder: (context,i) => ListTile(
          leading: Icon(menuOptions[i].icono),
          title: Text(menuOptions[i].nombre),
          onTap: () {

            /*
              final route = MaterialPageRoute(
                builder: (context) => ListView2Screen(),
              );
              Navigator.push(context, route);
            */


            Navigator.pushNamed(context, menuOptions[i].ruta);
          },
          trailing: Icon(Icons.arrow_forward_ios),
         ),
         separatorBuilder: (_,__) => Divider(),
         itemCount: menuOptions.length,
      ),
    );
  }
}