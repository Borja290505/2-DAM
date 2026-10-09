from PyQt6.QtCore import Qt, QSize
from PyQt6.QtWidgets import QApplication, QDialog, QDialogButtonBox, QLabel, QMainWindow, QPushButton, QVBoxLayout

from Dialog_2 import CustomDialog

class MainWindow(QMainWindow): 
    def __init__(self):
        super().__init__()
        self.setWindowTitle("MiAplicacion")

        boton = QPushButton("Pulsa Aqui")
        boton.clicked.connect(self.botonPulsado)
        self.setCentralWidget(boton)
                

    def botonPulsado(self):
        dig=CustomDialog()
        if dig.exec():
            print("El usuario ha aceptado")
        else:
            print("EL usuario ha rechado")
        
app = QApplication([])
window = MainWindow()
window.show()

app.exec()
