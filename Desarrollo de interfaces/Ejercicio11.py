from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton

class MainWindow(QMainWindow): # Asi se crea una clase

    
    
    def __init__(self): # Asi se crea una funcion
        super().__init__() # Siempre se pone asi para crear la funcion dentro de una clase (se llamara nada mas llamar a la clase)
        self.setWindowTitle("MiTitulo")
        self.cont = 0
 
        self.boton = QPushButton("No pulsado")
        self.boton.setCheckable(True)
        self.boton.clicked.connect(self.botonpulsadoYsoltado) # Denominado SIGNAL
        
        self.setCentralWidget(self.boton)

    def botonpulsadoYsoltado(self, pulsado):
             self.boton.setText([f"No pulsado {self.cont} " , f"pulsado{self.cont}"][pulsado])
             self.cont +=1
       
           
app = QApplication([])
window = MainWindow()
window.show()


app.exec() # Poner siempre si no la ventana se cierra instant