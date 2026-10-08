from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow): # Asi se crea una clase

    
    
    def __init__(self): # Asi se crea una funcion
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiTitulo")
        self.cont = 0
 
        self.boton = QPushButton("Pulsa")
        self.boton.setCheckable(True)
        self.boton.setChecked(True)
        self.boton.clicked.connect(self.botonpulsadoYsoltado) # Denominado SIGNAL
        
        self.setCentralWidget(self.boton)

    def botonpulsadoYsoltado(self):
        self.cont += 1
        print("Clickado")
        print(self.cont)
        print(self.boton.isChecked())

app = QApplication([])

window = MainWindow()

window.show()



app.exec() # Poner siempre si no la ventana se cierra instant