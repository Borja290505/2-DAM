from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton# Se importa solo lo que necesitas
from PyQt6.QtCore import QSize, Qt

class MainWindow(QMainWindow):
    clicks = 0

    def __init__(self): 
        super().__init__() 

        self.setWindowTitle("Mi Aplicación") 

        boton = QPushButton("Pulsa") 
        boton.setCheckable(True) 
        boton.clicked.connect(self.botonPulsado) 
        boton.clicked.connect(self.saberEstado)

        self.setCentralWidget(boton) 

    
    def botonPulsado(self): 
        self.clicks = self.clicks+1
        print(self.clicks)

    def saberEstado(self, checked):
        print("Estado: ", checked)
        


app = QApplication([]) 

window = MainWindow() 

window.show() 

app.exec()
