from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QLabel, QLineEdit,QVBoxLayout, QWidget

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi Aplicacion")

        #Definimos los widgets
        label = QLabel()
        input = QLineEdit()

        #Si el texto del imput cambia el label toma ese texto
        input.textChanged.connect(label.setText)

        #Creamos el layout con todos los widgets
        layout = QVBoxLayout()
        layout.addWidget(input)
        layout.addWidget(label)

        #Creamos el contenedor en el que se van a mostrar lo widgets
        contenedor = QWidget()
        contenedor.setLayout(layout)

        #Mostramos el contenedor por pantalla
        self.setCentralWidget(contenedor)
    
app = QApplication([])

window = MainWindow()

window.show()

app.exec()