package we.meet.onthetop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_boardlist.view.*

class MainActivity : AppCompatActivity() {

    private var boardList = arrayListOf<Board>(
        Board("1", "a", 4,"","2020-05-26"),
        Board("2", "b", 4,"","2020-05-26"),
        Board("3", "c", 4,"","2020-05-26"),
        Board("4", "d", 4,"","2020-05-26"),
        Board("5", "e", 4,"","2020-05-26"),
        Board("6", "f", 4,"","2020-05-26")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mAdapter = BoardAdapter(this, boardList) { board ->
            //클릭시 이벤트
            Toast.makeText(this,"선택한 게시물: ${board.title}",Toast.LENGTH_LONG).show()

        }
        mRecyclerView.adapter = mAdapter

        val lm = LinearLayoutManager(this)
        mRecyclerView.layoutManager = lm
        mRecyclerView.setHasFixedSize(true)
    }

}