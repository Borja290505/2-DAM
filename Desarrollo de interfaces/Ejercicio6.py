from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow): # Asi se crea una clase

    def botonpulsado(self): # Siempre que hagamos una funcion dentro de una clase se pone el self (SLOT)
        print("Boton Pulsado")

    def saberEstado(self, checked):
        print (checked)

    

    
    def __init__(self): # Asi se crea una funcion
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiTitulo")

        boton = QPushButton("Pulsa")
        boton.setCheckable(True)
        boton.clicked.connect(self.botonpulsado) # Denominado SIGNAL
        boton.clicked.connect(self.saberEstado) # Denominado SIGNAL



        self.setCentralWidget(boton)

app = QApplication([])

window = MainWindow()

window.show()



app.exec() # Poner siempre si no la ventana se cierra instant