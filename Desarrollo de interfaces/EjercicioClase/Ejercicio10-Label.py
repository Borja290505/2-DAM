from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QMainWindow, QLabel, QWidget

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi Aplicacion")

        #Definimos los widgets
        label = QLabel("Hola")

        #Definimos los estilos del label
        formato = label.font()
        formato.setPointSize(30)
        formato.setFamily("Arial")
        formato.setBold(True)
        label.setFont(formato)
        label.setAlignment(Qt.AlignmentFlag.AlignHCenter | Qt.AlignmentFlag.AlignVCenter)

        #Mostramos el contenedor por pantalla
        self.setCentralWidget(label)
    
app = QApplication([])

window = MainWindow()

window.show()

app.exec()