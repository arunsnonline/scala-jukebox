package com.jukebox.cli

object CliMain {

  def main(args: Array[String]): Unit = {
    val rowArtist = new RowArtist()
    val normalCell = TableCell()
    val smallCell = TableCell(cellWidth = 2)
    val cellList: List[TableCell] = List(smallCell, normalCell, normalCell, normalCell, normalCell)
    rowArtist.drawFirstRow(TableRow(numberOfColumns = 5,cellList = cellList))
    rowArtist.drawNextRow(TableRow(numberOfColumns = 5,cellList = cellList))
  }

}
