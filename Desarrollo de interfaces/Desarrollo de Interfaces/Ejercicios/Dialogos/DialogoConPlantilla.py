from PyQt6.QtCore import Qt, QSize
from PyQt6.QtWidgets import QApplication, QDialog, QDialogButtonBox, QLabel, QMainWindow, QMessageBox, QPushButton, QVBoxLayout

class MainWindow(QMainWindow): 
    def __init__(self):
        super().__init__()
        self.setWindowTitle("MiAplicacion")

        boton = QPushButton("Pulsa Aqui")
        boton.clicked.connect(self.botonPulsado)
        self.setCentralWidget(boton)
                

    def botonPulsado(self):
        dig=QMessageBox(self)
        dig.setWindowTitle("Cuadro de mensaje")
        dig.setText("Es es el mensaje de mi cuadro de mensaje")
        dig.setStandardButtons(QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.Cancel)
        dig.setIcon(QMessageBox.Icon.Information)
        if dig.exec() == QMessageBox.StandardButton.Yes:
            print("El usuario ha aceptado")
        else:
            print("EL usuario ha rechado")
        
app = QApplication([])
window = MainWindow()
window.show()

app.exec()
