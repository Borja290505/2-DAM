from Ej8 import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication

#from PyQt6.QtWidgets import QApplication, QMessageBox,QDateEdit, QHBoxLayout, QRadioButton, QTextEdit, QWidget, QPushButton,QMainWindow,QLabel,QLineEdit,QVBoxLayout,QCheckBox,QComboBox,QListWidget,QAbstractItemView,QSlider,QDial,QCalendarWidget



class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow,self).__init__()
        self.setupUi(self)
        self.show()
        self.comboBox.currentIndexChanged.connect(self.cambiarEstilo)


    def cambiarEstilo(self):
        with open(["Estilos/estiloEj1.qss","Estilos/estiloEj2.qss","Estilos/estiloEj3.qss"][self.comboBox.currentIndex()],"r") as f:
            app.setStyleSheet(f.read())



app = QApplication([])


ventana = MainWindow()
ventana.show()
app.exec()
