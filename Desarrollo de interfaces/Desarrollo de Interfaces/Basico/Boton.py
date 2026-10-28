from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton
from PyQt6.QtCore import QSize, Qt

class MainWindow(QMainWindow):
    def __init__(self): 
        super().__init__() 

        self.setWindowTitle("Mi Aplicación") 

        boton = QPushButton("Pulsa") 

        self.setFixedSize(QSize(400,300)) 

        self.setCentralWidget(boton) 


app = QApplication([]) 

window = MainWindow() 

window.show() 

app.exec() 
