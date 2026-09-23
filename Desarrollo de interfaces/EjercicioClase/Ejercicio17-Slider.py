from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QListWidget, QMainWindow, QSlider

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi Aplicacion")

        #Definimos los widgets
        slidler = QSlider(Qt.Orientation.Horizontal)
        slidler.setRange(-10,10)

        slidler.valueChanged.connect(self.valorCambiado)
        slidler.sliderMoved.connect(self.valorCambiado)

        #texto.textChanged.connect(self.textoCambiado)

        #Mostramos el contenedor por pantalla
        self.setCentralWidget(slidler)

    def valorCambiado(self,value):
        print(value)
    
app = QApplication([])

window = MainWindow()

window.show()

app.exec()