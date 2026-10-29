from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton# Se importa solo lo que necesitas
from PyQt6.QtCore import QSize, Qt

class MainWindow(QMainWindow):
    def __init__(self): 
        super().__init__() 
        
        self.setWindowTitle("Mi Aplicación") 

        self.boton = QPushButton("No pulsado") 
        self.boton.setCheckable(True)
        self.boton.clicked.connect(self.botonPulsadoYSoltado) 

        self.setCentralWidget(self.boton) 
        
    def botonPulsadoYSoltado(self, estado):
        self.boton.setText(["No pulsado","Pulsado"][estado])

app = QApplication([]) 

window = MainWindow() 

window.show()

app.exec()