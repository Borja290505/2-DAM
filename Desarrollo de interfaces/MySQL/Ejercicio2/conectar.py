from operator import le
import re
import sys

import mysql.connector
from Ejercicio1 import Ui_MainWindow

from PyQt6.QtWidgets import QMainWindow, QApplication, QTableWidget, QTableWidgetItem, QVBoxLayout

class MainWindow(QMainWindow,Ui_MainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Conectar BD")
        self.con = mysql.connector.connect(
            host = "localhost",
            port=3306,
            user="root",
            password="1234",
            database="capitales"
        )

            self.contenedor = QVBoxLayout()
            self.table = QTableWidget()
            self.contenedor.addWidget(self.table)
            self.cargarDatos()
    def cargarDatos(self):
        cursor=self.con.cursor()
        sql = "SELECT * FROM capitales"
        cursor.execute(sql)
        columnas = [desc[0] for desc in cursor.description]
        self.resultado = cursor.fetchall()
        self.table.setColumnCount(len(columnas))
        self.table.setRowCount(len(columnas))
        self.table.setHorizontalHeaderLabels(columnas)

        for fila,registro in enumerate(self.resultado):
            for col, valor in enumerate(registro):
                texto = "" if valor is None else str(valor)
                item=QTableWidgetItem(texto)
                self.table.setItem(fila,col,item)


app = QApplication(sys.argv)
ventana = MainWindow()
ventana.show()
app.exec()