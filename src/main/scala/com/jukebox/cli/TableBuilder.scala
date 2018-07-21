package com.jukebox.cli

sealed trait BaseTableMeta

case class TableRow(numberOfColumns: Int = 0,
                    rowDelimiter: String = "-",
                    rowHeight: Int = 1,
                    cellList: List[TableCell]) extends BaseTableMeta

case class TableCell(cellWidth: Int = 5,
                     cellContent: String = "",
                     cellDelimiter: String = "|") extends BaseTableMeta

class RowArtist {

  def drawHeaderRow(tableRow: TableRow) = {
    val rowTop = tableRow.cellList
      .map(tc => getDelimiter(tableRow) * tc.cellWidth)
      .foldRight("")(_ + _)
    val rowBottom = rowTop
    val rowContent = tableRow.cellList
      .map(tc => getDelimiter(tc) + (" " * tc.cellWidth))
      .foldRight("")(_ + _)

    import RepeatAction._
    println(rowTop)
    tableRow.rowHeight times println(rowContent)
    println(rowBottom)
  }

  def drawNextRow(tableRow: TableRow) = {
    val rowBottom = tableRow.cellList
      .map(tc => getDelimiter(tableRow) * tc.cellWidth)
      .foldRight("")(_ + _)
    val rowContent = tableRow.cellList
      .map(tc => getDelimiter(tc) + (" " * tc.cellWidth))
      .foldRight("")(_ + _)

    import RepeatAction._
    tableRow.rowHeight times println(rowContent)
    println(rowBottom)
  }

  private def getDelimiter(tableMeta: BaseTableMeta): String = {
    tableMeta match {
      case row: TableRow => row.rowDelimiter
      case cell: TableCell => cell.cellDelimiter
      case _ => ""
    }
  }
}


