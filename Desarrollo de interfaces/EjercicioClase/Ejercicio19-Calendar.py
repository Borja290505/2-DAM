from PyQt6.QtCore import QSize, Qt
from PyQt6.QtWidgets import QApplication, QListWidget, QMainWindow, QCalendarWidget

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi Aplicacion")

        #Definimos los widgets
        self.calendar = QCalendarWidget()
        self.calendar.selectionChanged.connect(self.mostrarFecha)


        #Mostramos el contenedor por pantalla
        self.setCentralWidget(self.calendar)

    def mostrarFecha(self):
        print(self.calendar.selectedDate().toString("dd/MM/yyyy"))
    
app = QApplication([])

window = MainWindow()

window.show()

app.exec()