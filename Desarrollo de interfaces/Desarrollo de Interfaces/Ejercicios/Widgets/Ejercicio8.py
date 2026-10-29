from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow): # Asi se crea una clase

    
    
    def __init__(self): # Asi se crea una funcion
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiTitulo")
        self.cont = 0
 
        boton = QPushButton("Pulsa")
        boton.clicked.connect(self.botonpulsadoYsoltado) # Denominado SIGNAL
        boton.pressed.connect(self.botonpulsado)
        boton.released.connect(self.botonsoltado)


        self.setCentralWidget(boton)

    def botonpulsadoYsoltado(self):
        print("Clickado")
        self.cont += 1
        print(self.cont)

    def botonpulsado(self):
        print("Pulsado")

    def botonsoltado(self):
        print("Soltado")
        
        

app = QApplication([])

window = MainWindow()

window.show()



app.exec() # Poner siempre si no la ventana se cierra instant