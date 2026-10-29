import 'package:flutter/material.dart';

class BotonesScreen extends StatelessWidget {
   
  const BotonesScreen({Key? key}) : super(key: key);
  
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Botones - Buttons'),
      ),
      body: const _Buttons(), 
      floatingActionButton: FloatingActionButton(
        child: const Icon(Icons.arrow_back_ios),
        onPressed: () {
          Navigator.pop(context);
        }
      ),
    );
  }
}

class _Buttons extends StatelessWidget {
  const _Buttons({
    super.key,
  });

  @override
  Widget build(BuildContext context) {

    return SizedBox(
      width: double.infinity,
      child: Padding(
        
        padding: const EdgeInsets.symmetric(horizontal: 10, vertical: 10),
        child: Column(
           children: [
            ElevatedButton(
              onPressed: () {}, 
              child: const Text('Elevated button')
            ),
              
            ElevatedButton(
              onPressed: () {}, 
              child: const Text('Elevated Disabled')
            ),

            ElevatedButton.icon(
              onPressed: () {},
              label: const Text('Elevated icon'),
              icon: const Icon(Icons.terminal),
            ),

            FilledButton(
              onPressed: () {},
              child: Text('Filled Button')
            ),

            FilledButton.icon(
              onPressed: () {}, 
              label: Text('Filled Icon'),
              icon: const Icon(Icons.terminal),
              iconAlignment: .end,
            ),

            OutlinedButton(
              onPressed: () {}, 
              child: Text('Outlined')
            ),

            OutlinedButton.icon(
              onPressed: () {}, 
              label: Text('Outlined'),
              icon: Icon(Icons.offline_pin),
            ),

            TextButton(
              onPressed: () {}, 
              child: Text('Text Button')
            ),

            TextButton.icon(
              onPressed: () {}, 
              label: Text('Text Button'),
              icon: Icon(Icons.access_alarms_outlined),
            ),

            IconButton(
              onPressed: () {}, 
              icon: Icon(Icons.face_2_outlined),
              style: ButtonStyle(backgroundColor:  WidgetStatePropertyAll(Colors.white)),
            ),
           ],
        ),
      ),
    );
  }
}
class _BotonPersonalizado extends StatelessWidget {
  const new({super.key});

  @override
  Widget build(BuildContext context) {
    return const Placeholder();
  }
}