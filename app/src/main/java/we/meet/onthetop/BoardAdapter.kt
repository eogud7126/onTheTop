package we.meet.onthetop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BoardAdapter(private val context: Context, private val boardList: ArrayList<Board>, val itemClick: (Board)->Unit ): RecyclerView.Adapter<BoardAdapter.Holder>(){

        inner class Holder(itemView: View, itemClick: (Board) -> Unit): RecyclerView.ViewHolder(itemView){
            private val boardImg = itemView.findViewById<ImageView>(R.id.boardImg)
            private val boardTitle = itemView.findViewById<TextView>(R.id.boardTitleTv)
            private val boardSub = itemView.findViewById<TextView>(R.id.boardSubTv)
            private val boardDate = itemView.findViewById<TextView>(R.id.boardDateTv)
            private val boardCommentCnt = itemView.findViewById<TextView>(R.id.boardCommentTv)

            fun bind(board: Board, context: Context) {
                if (board.boardImage != "") {
                    val resourceId = context.resources.getIdentifier(
                        board.boardImage,
                        "drawable",
                        context.packageName
                    )
                    boardImg?.setImageResource(resourceId)
                } else {
                    boardImg?.setImageResource(R.mipmap.ic_launcher)
                }
                boardTitle?.text = board.title
                boardSub?.text = board.subTitle
                boardDate?.text = board.date
                boardCommentCnt?.text = board.commentCnt.toString()

                itemView.setOnClickListener { itemClick(board) }
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //화면을 최초 로딩하여 만들어진 View가 없는 경우, xml파일을 inflate하여 ViewHolder를 생성한다.
        val view = LayoutInflater.from(context).inflate(R.layout.item_boardlist,parent,false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        //RecyclerView로 만들어지는 item의 총 개수를 반환한다.
        return boardList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //위의 onCreateViewHolder에서 만든 view와 실제 입력되는 각각의 데이터를 연결한다.
        holder.bind(boardList[position],context)
    }

}
