import 'package:contador/presentation/widgets/boton_personalizado.dart';
import 'package:flutter/material.dart';

class ContadorScreen extends StatefulWidget {
  const new({super.key});

  @override
  State<ContadorScreen> createState() => _ContadorScreenState();
}

class _ContadorScreenState extends State<ContadorScreen> {
  int contador = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Contador App'), 
        backgroundColor: Colors.blue.shade100,
        centerTitle: true,
        /*leading: IconButton(
          onPressed: () {
            contador = 0;
            setState(() {});
          }, 
          icon: Icon(Icons.refresh_rounded)
          ),*/
        actions: [
          IconButton(
            onPressed: () {
              contador = 0;
              setState(() {});
            }, 
            icon: Icon(Icons.refresh_rounded)
          ),

        ],
        ),
      body: Center(
        child: Column(
          mainAxisAlignment: .center,
          children: [
            Text(
              '$contador',
              style: TextStyle(fontSize: 160, fontWeight: .w100),
            ),
            Text('Click${ contador == 1 ? '' : 's'}', style: TextStyle(fontSize: 25)),
            /*if ( contador != 1) Text('Clicks', style: TextStyle(fontSize: 25)),
            if ( contador == 1) Text('Click', style: TextStyle(fontSize: 25)),*/
          ],
        ),
      ),
      floatingActionButton: Column(
        mainAxisAlignment: .end,
        children: [
          CustomButton( 
            icono: Icons.add,
            onPressed: () {
              setState(() {
                contador++;
              });
            },
          ),
          SizedBox(height: 10,),
          CustomButton(
            icono: Icons.exposure_minus_1,
            onPressed: () {
              setState(() {
                if (contador==0)return;
                contador--;
              });
            },
          ),
          SizedBox(height: 10,),
          CustomButton(
            icono: Icons.refresh_rounded,
            onPressed: () {
              setState(() {
                contador = 0;
              });
            },),
        ],
      )
    );
  }
}

class CustomButton extends StatelessWidget {

  final IconData icono;
  final VoidCallback? onPressed;

  const new({
    super.key,
    required this.icono,
    this.onPressed
  });

  @override
  Widget build(BuildContext context) {
    return FloatingActionButton(
      //shape: StadiumBorder(),
      enableFeedback: true,
      elevation: 5,
      onPressed: onPressed,
      child: Icon( icono ),
    );
  }
}

