from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QListWidget, QMainWindow, QSpinBox

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi Aplicacion")

        #Definimos los widgets
        spinBox = QSpinBox()
        spinBox.setRange(-10,10)
        spinBox.setSingleStep(2)
        spinBox.setSuffix("€")
        spinBox.valueChanged.connect(self.valorCambiado)

        #texto.textChanged.connect(self.textoCambiado)

        #Mostramos el contenedor por pantalla
        self.setCentralWidget(spinBox)

    def valorCambiado(self,value):
        print(value)
    
app = QApplication([])

window = MainWindow()

window.show()

app.exec()