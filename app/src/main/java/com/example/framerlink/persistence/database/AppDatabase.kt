package com.example.framerlink.persistence.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.framerlink.bean.Product
import com.example.framerlink.persistence.Dao.Converters
import com.example.framerlink.persistence.Dao.ProductDao
import com.example.framerlink.utils.ioThread
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Product::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this){
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "framerlink.db"
            )
                .addCallback(object : RoomDatabase.Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        CoroutineScope(Dispatchers.IO).launch {
                            getInstance(context).productDao()
                                .insertProducts(PREPOPULATE_DATA)
                        }
                    }
                })
                .build()
                .also { INSTANCE = it }
        }

        private val PREPOPULATE_DATA = listOf(
            Product(
                id = "1",
                name = "粮食作物",
                description = "",
                tags = "",
                rating = 4.8,
                price = 299.0,
                coverUrl = "https://example.com/kb.jpg",
                imageUrls = listOf("https://example.com/kb1.jpg", "https://example.com/kb2.jpg"),
                active = true,
                likes = 120,
                normal = 10,
                dislikes = 2,
                capacity = "现货"
            ),
            Product(
                id = "2",
                name = "粮食作物",
                description = "",
                tags = "",
                rating = 4.8,
                price = 299.0,
                coverUrl = "https://example.com/kb.jpg",
                imageUrls = listOf("https://example.com/kb1.jpg", "https://example.com/kb2.jpg"),
                active = true,
                likes = 120,
                normal = 10,
                dislikes = 2,
                capacity = "现货"
            )
        )
    }
}