from PyQt6.QtCore import Qt, QSize
from PyQt6.QtWidgets import QApplication, QDialog, QDialogButtonBox, QLabel, QMainWindow, QMessageBox, QPushButton, QVBoxLayout, QWidget


class OtraVentana(QWidget):
    def __init__(self):
            super().__init__()
            self.setWindowTitle("MiAplicacion")
            plantilla= QVBoxLayout()
            self.etiqueta=QLabel("Otra ventana")
            plantilla.addWidget(self.etiqueta)
            self.setLayout(plantilla)

            
class MainWindow(QMainWindow): 
    def __init__(self):
        super().__init__()
        self.setWindowTitle("MiAplicacion")

        boton = QPushButton("Pulsa Aqui")
        boton.clicked.connect(self.mostrarVentana)
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

    def mostrarVentana(self):
         self.window = OtraVentana()
         self.window.show()



        
app = QApplication([])
window = MainWindow()
window.show()

app.exec()
