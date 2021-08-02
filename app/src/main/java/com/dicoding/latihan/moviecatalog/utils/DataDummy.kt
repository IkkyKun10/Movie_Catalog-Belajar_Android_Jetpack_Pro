package com.dicoding.latihan.moviecatalog.utils

import com.dicoding.latihan.moviecatalog.data.local.entity.MoviesEntity
import com.dicoding.latihan.moviecatalog.data.local.entity.TvShowEntity
import com.dicoding.latihan.moviecatalog.data.remote.response.MovieResponse
import com.dicoding.latihan.moviecatalog.data.remote.response.TvResponse

object DataDummy {

    fun generateDummyMovies() : List<MoviesEntity> {
        val movies = ArrayList<MoviesEntity>()

        movies.add(
            MoviesEntity("m1",
                "Alita",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8LyWVwDbU4vsOwns8RxOB9aX73l.jpg",
            "14/02/2019 (US)",
            "Aksi, Cerita Fiksi, Petualangan",
            "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa.",
            "Robert Rodriguez",
            "71",
                false)
        )

        movies.add(MoviesEntity("m2",
        "Aquaman",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zdw7Wf97vsQ0YnGomxDqfcEdUjX.jpg",
        "21/12/2018 (US)",
        "Aksi, Petualangan, Fantasi",
        "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
        "James Wan",
        "69",
            false)
        )

        movies.add(
            MoviesEntity("m3",
        "Bohemian",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zpf6mrGZ0BbdsfzwUP0Nzp3hJEb.jpg",
        "02/11/2018 (US)",
                "Musik, Drama, Sejarah",
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "Bryan Singer",
            "80",
                false)
        )

        movies.add(
            MoviesEntity("m4",
                "How To Train Dragon",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg",
                "22/02/2019 (US)",
                "Animasi, Keluarga, Petualangan",
                "Ketika Hiccup memenuhi mimpinya untuk menciptakan utopia naga yang damai, penemuan Toothless 'dari pasangan yang tak teruji dan sukar ditangkap membuat Night Fury menjauh. Ketika bahaya meningkat di rumah dan pemerintahan Hiccup sebagai kepala desa diuji, baik naga dan pengendara harus membuat keputusan yang mustahil untuk menyelamatkan jenis mereka.",
                "Dean DeBlois",
                "78",
                false)
        )

        movies.add(MoviesEntity("m5",
            "Infinity War",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ypX47SBSThTbB40AIJ22eOUCpjU.jpg",
            "21/12/2018 (US)",
            "Petualangan, Aksi, Cerita Fiksi",
            "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti.",
            "Anthony Russo",
            "83",
            false)
        )

        movies.add(MoviesEntity("m6",
            "Master Z: Ip Man Legacy ",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6VxEvOF7QDovsG6ro9OVyjH07LF.jpg",
            "26/12/2018",
            "Aksi",
            "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
            "Yuen Woo-ping",
            "57",
            false)
        )

        movies.add(MoviesEntity("m7",
            "Mortal Engines",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/sBdtAsZNVPMOOYcq8zh0XULqU9T.jpg",
            "14/12/2018 (US)",
            "Petualangan, Cerita Fiksi",
            "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
            "Christian Rivers",
            "61",
            false)
        )

        movies.add(MoviesEntity("m8",
            "Robin Hood",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7VuQnjdmS93gkee96ErNPVUNtw6.jpg",
            "21/11/2018 (US)",
            "Petualangan, Aksi, Cerita Seru",
            "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
            "Otto Bathurst",
            "59",
            false)
        )

        movies.add(MoviesEntity("m9",
            "Glass",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xEXDpI1r4VNCBwz3DlAbNzefMnu.jpg",
            "18/01/2019 (US)",
            "Cerita Seru, Drama, Cerita Fiksi",
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            "M. Night Shyamalan",
            "66",
            false)
        )

        movies.add(MoviesEntity("m10",
            "Spiderman: Into The Spider-Verse",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ybQSBSrINtjWsJQ6Ih8sva8HlEZ.jpg",
            "14/12/2018 (US)",
            "Aksi, Petualangan, Animasi, Cerita Fiksi, Komedi",
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
            "Rodney Rothman",
            "84",
            false)
        )


        return movies
    }

    fun generateDummyTvshow() :List<TvShowEntity> {

        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(TvShowEntity("t1",
        "Arrow",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
        "2012",
        "Kejahatan, Drama, Misteri, Aksi & Petualangan",
        "Arrow adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow",
        "Greg Berlanti, Marc Guggenheim, Andrew Kreisberg",
        "66",
            false))

        tvShows.add(TvShowEntity("t2",
            "Fairy Tale",
            "https://i.pinimg.com/564x/0c/8f/93/0c8f938bcae31f5ecfb1fafd6818ad68.jpg",
            "2009",
            "Action, Adventure, Comedy, Magic, Fantasy, Shounen",
            "In the mystical land of Fiore, magic exists as an essential part of everyday life. Countless magic guilds lie at the core of all magical activity, and serve as venues for like-minded mages to band together and take on job requests. Among them, Fairy Tail stands out from the rest as a place of strength, spirit, and family.\n" + "Lucy Heartfilia is a young mage searching for celestial gate keys, and her dream is to become a full-fledged wizard by joining this famous guild. In her search, she runs into Natsu Dragneel and his partner Happy, who are on a quest to find Natsu's foster father, the dragon Igneel Upon being tricked by a man, Lucy falls under an abduction attempt, only to be saved by Natsu. To her shock, he reveals that he is a member of Fairy Tail and invites her to join them. There, Lucy meets the guild's strange members, such as the ice wizard Gray Fullbuster and magic swordswoman Erza Scarlet. Together as a family, they battle the forces of evil, help those in need, and gain new friends, all the while enjoying the never-ending adventure that is Fairy Tail.Greg Berlanti, Marc Guggenheim, Andrew Kreisberg",
            "Satelight, A-1 Pictures",
            "76",
            false))

        tvShows.add(TvShowEntity("t3",
            "The Flash",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4YaerJEQtWrAMPwjDZArSxhL3fC.jpg",
            "2014",
            "Drama, Sci-fi & Fantasy",
            "Setelah akselerator partikel menyebabkan badai aneh, Penyelidik CSI Barry Allen disambar petir dan jatuh koma. Beberapa bulan kemudian dia terbangun dengan kekuatan kecepatan super, memberinya kemampuan untuk bergerak melalui Central City seperti malaikat penjaga yang tak terlihat. Meskipun awalnya senang dengan kekuatan barunya, Barry terkejut menemukan bahwa dia bukan satu-satunya \"manusia meta\" yang diciptakan setelah ledakan akselerator - dan tidak semua orang menggunakan kekuatan baru mereka untuk kebaikan. Barry bermitra dengan S.T.A.R. Lab dan mendedikasikan hidupnya untuk melindungi yang tidak bersalah. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash.",
            "Greg Berlanti, Geoff Johns, Andrew Kreisberg",
            "76",
            false))

        tvShows.add(TvShowEntity("t4",
            "Game Of Throne",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bk7SJsNtVP97faavetnurgXdrOF.jpg",
            "2011",
            "Sci-fi & Fantasy, Drama, Aksi & Petualangan",
            "Tujuh keluarga bangsawan berjuang untuk menguasai tanah mitos Westeros. Gesekan antara rumah-rumah mengarah ke perang skala penuh. Semua sementara kejahatan yang sangat kuno terbangun di utara terjauh. Di tengah-tengah perang, perintah militer yang diabaikan, Night's Watch, adalah yang berdiri di antara alam manusia dan kengerian es di luarnya David Benioff Greg Berlanti, Marc Guggenheim, Andrew Kreisberg",
            "David Benioff, D. B. Weiss",
            "84",
            false))

        tvShows.add(TvShowEntity("t5",
            "Gotham",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9jbJLks2YTBv7HeahdfkeeIuYpc.jpg",
            "2014",
            "Drama, Kejahatan, Sci-fi & Fantasy",
            "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?",
            "Bruno Heller",
            "75",
            false))

        tvShows.add(TvShowEntity("t6",
            "Hanna",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/toQzJUE9VM3erjs1f5sn6Aa4deL.jpg",
            "2019",
            "Aksi & Petualangan, Drama",
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            "David Farr",
            "75",
            false))

        tvShows.add(TvShowEntity("t7",
            "Iron Fish",
            "https://www.sanity.com.au/media/Images/fullimage/484582/SDC_1401408_2018-20-11--16-14-19.jpg",
            "2017",
            "Aksi & Petualangan, Drama, Sci-fi & Fantasy",
            "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
            "Scott Buck",
            "65",
            false))

        tvShows.add(TvShowEntity("t8",
            "Naruto Shippuden",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/3JGx8nRdsMWB6crJtIqRBteK5V3.jpg",
            "2007",
            "Keluarga, Aksi, Animasi, Petualangan, Fantasi",
            "Naruto Shippuuden adalah kelanjutan dari serial TV animasi asli Naruto. Kisah ini berkisah tentang Uzumaki Naruto yang lebih tua dan sedikit lebih matang dan upayanya untuk menyelamatkan temannya Uchiha Sasuke dari cengkeraman Shinobi seperti ular, Orochimaru. Setelah 2 setengah tahun, Naruto akhirnya kembali ke desanya Konoha, dan mulai mewujudkan ambisinya, meskipun itu tidak akan mudah, karena Ia telah mengumpulkan beberapa musuh (lebih berbahaya), seperti organisasi shinobi. ; Akatsuki.",
            "Hajime Kamegaki",
            "84",
            false))

        tvShows.add(TvShowEntity("t9",
            "Super Girl",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/m25hItTmnC4l12hsKU1fNuo4Grc.jpg",
            "2015",
            "Drama, Sci-fi & Fantasy, Aksi & Petualangan",
            "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
            "Greg Berlanti, Ali Adler, Andrew Kreisberg",
            "72",
            false))

        tvShows.add(TvShowEntity("t10",
            "The Walking Dead",
            "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
            "2010",
            "Aksi & Petualangan, Drama, Sci-fi & Fantasy",
            "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            "Frank Darabont",
            "80",
            false))



        return tvShows

    }

    fun generateRemoteDummyMovies() : List<MovieResponse> {
        val movies = ArrayList<MovieResponse>()

        movies.add(MovieResponse(
                moviesId = "m1",
                title = "Alita",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8LyWVwDbU4vsOwns8RxOB9aX73l.jpg",
                date = "14/02/2019 (US)",
                genre = "Aksi, Cerita Fiksi, Petualangan",
                description = "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa.",
                director = "Robert Rodriguez",
                score = "71")
        )

        movies.add(MovieResponse(
                moviesId = "m2",
                title = "Aquaman",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zdw7Wf97vsQ0YnGomxDqfcEdUjX.jpg",
                date = "21/12/2018 (US)",
                genre = "Aksi, Petualangan, Fantasi",
                description = "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                director = "James Wan",
                score = "69")
        )

        movies.add(MovieResponse(
                moviesId = "m3",
                title = "Bohemian",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zpf6mrGZ0BbdsfzwUP0Nzp3hJEb.jpg",
                date = "02/11/2018 (US)",
                genre = "Musik, Drama, Sejarah",
                description = "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                director = "Bryan Singer",
                score = "80")
        )

        movies.add(MovieResponse(
                moviesId = "m4",
                title = "How To Train Dragon",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ygGmAO60t8GyqUo9xYeYxSZAR3b.jpg",
                date = "22/02/2019 (US)",
                genre = "Animasi, Keluarga, Petualangan",
                description = "Ketika Hiccup memenuhi mimpinya untuk menciptakan utopia naga yang damai, penemuan Toothless 'dari pasangan yang tak teruji dan sukar ditangkap membuat Night Fury menjauh. Ketika bahaya meningkat di rumah dan pemerintahan Hiccup sebagai kepala desa diuji, baik naga dan pengendara harus membuat keputusan yang mustahil untuk menyelamatkan jenis mereka.",
                director = "Dean DeBlois",
                score = "78")
        )

        movies.add(MovieResponse(
                moviesId = "m5",
                title = "Infinity War",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ypX47SBSThTbB40AIJ22eOUCpjU.jpg",
                date = "21/12/2018 (US)",
                genre = "Petualangan, Aksi, Cerita Fiksi",
                description = "Karena Avengers dan sekutunya terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh seorang pahlawan, bahaya baru telah muncul dari bayangan kosmik: Thanos. Seorang lalim penghujatan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan yang tak terbayangkan, dan menggunakannya untuk menimbulkan kehendak memutar pada semua realitas. Segala sesuatu yang telah diperjuangkan oleh Avengers telah berkembang hingga saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti.",
                director = "Anthony Russo",
                score = "83")
        )

        movies.add(MovieResponse(
                moviesId = "m6",
                title = "Master Z: Ip Man Legacy",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6VxEvOF7QDovsG6ro9OVyjH07LF.jpg",
                date = "26/12/2018",
                genre = "Aksi",
                description = "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                director = "Yuen Woo-ping",
                score = "57")
        )

        movies.add(MovieResponse(
                moviesId = "m7",
                title = "Mortal Engines",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/sBdtAsZNVPMOOYcq8zh0XULqU9T.jpg",
                date = "14/12/2018 (US)",
                genre = "Petualangan, Cerita Fiksi",
                description = "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                director = "Christian Rivers",
                score = "61")
        )

        movies.add(MovieResponse(
                moviesId = "m8",
                title = "Robin Hood",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7VuQnjdmS93gkee96ErNPVUNtw6.jpg",
                date = "21/11/2018 (US)",
                genre = "Petualangan, Aksi, Cerita Seru",
                description = "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                director = "Otto Bathurst",
                score = "59")
        )

        movies.add(MovieResponse(
                moviesId = "m9",
                title = "Glass",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xEXDpI1r4VNCBwz3DlAbNzefMnu.jpg",
                date = "18/01/2019 (US)",
                genre = "Cerita Seru, Drama, Cerita Fiksi",
                description = "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                director = "M. Night Shyamalan",
                score = "66")
        )

        movies.add(MovieResponse(
                moviesId = "m10",
                title = "Spiderman: Into The Spider-Verse",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ybQSBSrINtjWsJQ6Ih8sva8HlEZ.jpg",
                date = "14/12/2018 (US)",
                genre = "Aksi, Petualangan, Animasi, Cerita Fiksi, Komedi",
                description = "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                director = "Rodney Rothman",
                score = "84")
        )

        return movies
    }

    fun generateRemoteDummyTvShow() :List<TvResponse> {
        val tvShows = ArrayList<TvResponse>()

        tvShows.add(TvResponse(
                tvShowId = "t1",
                title = "Arrow",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                date = "2012",
                genre = "Kejahatan, Drama, Misteri, Aksi & Petualangan",
                description = "Arrow adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow",
                kreator = "Greg Berlanti, Marc Guggenheim, Andrew Kreisberg",
                score = "66"))

        tvShows.add(TvResponse(
                tvShowId = "t2",
                title = "Fairy Tale",
                image = "https://i.pinimg.com/564x/0c/8f/93/0c8f938bcae31f5ecfb1fafd6818ad68.jpg",
                date = "2009",
                genre = "Action, Adventure, Comedy, Magic, Fantasy, Shounen",
                description = "In the mystical land of Fiore, magic exists as an essential part of everyday life. Countless magic guilds lie at the core of all magical activity, and serve as venues for like-minded mages to band together and take on job requests. Among them, Fairy Tail stands out from the rest as a place of strength, spirit, and family.\n" + "Lucy Heartfilia is a young mage searching for celestial gate keys, and her dream is to become a full-fledged wizard by joining this famous guild. In her search, she runs into Natsu Dragneel and his partner Happy, who are on a quest to find Natsu's foster father, the dragon Igneel Upon being tricked by a man, Lucy falls under an abduction attempt, only to be saved by Natsu. To her shock, he reveals that he is a member of Fairy Tail and invites her to join them. There, Lucy meets the guild's strange members, such as the ice wizard Gray Fullbuster and magic swordswoman Erza Scarlet. Together as a family, they battle the forces of evil, help those in need, and gain new friends, all the while enjoying the never-ending adventure that is Fairy Tail.Greg Berlanti, Marc Guggenheim, Andrew Kreisberg",
                kreator = "Satelight, A-1 Pictures",
                score = "76"))

        tvShows.add(TvResponse(
                tvShowId = "t3",
                title = "The Flash",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4YaerJEQtWrAMPwjDZArSxhL3fC.jpg",
                date = "2014",
                genre = "Drama, Sci-fi & Fantasy",
                description = "Setelah akselerator partikel menyebabkan badai aneh, Penyelidik CSI Barry Allen disambar petir dan jatuh koma. Beberapa bulan kemudian dia terbangun dengan kekuatan kecepatan super, memberinya kemampuan untuk bergerak melalui Central City seperti malaikat penjaga yang tak terlihat. Meskipun awalnya senang dengan kekuatan barunya, Barry terkejut menemukan bahwa dia bukan satu-satunya \"manusia meta\" yang diciptakan setelah ledakan akselerator - dan tidak semua orang menggunakan kekuatan baru mereka untuk kebaikan. Barry bermitra dengan S.T.A.R. Lab dan mendedikasikan hidupnya untuk melindungi yang tidak bersalah. Untuk saat ini, hanya beberapa teman dekat dan rekan yang tahu bahwa Barry secara harfiah adalah manusia tercepat, tetapi tidak lama sebelum dunia mengetahui apa yang menjadi Barry Allen ... The Flash.",
                kreator = "Greg Berlanti, Geoff Johns, Andrew Kreisberg",
                score = "76"))

        tvShows.add(TvResponse(
                tvShowId = "t4",
                title = "Game Of Throne",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bk7SJsNtVP97faavetnurgXdrOF.jpg",
                date = "2011",
                genre = "Sci-fi & Fantasy, Drama, Aksi & Petualangan",
                description = "Tujuh keluarga bangsawan berjuang untuk menguasai tanah mitos Westeros. Gesekan antara rumah-rumah mengarah ke perang skala penuh. Semua sementara kejahatan yang sangat kuno terbangun di utara terjauh. Di tengah-tengah perang, perintah militer yang diabaikan, Night's Watch, adalah yang berdiri di antara alam manusia dan kengerian es di luarnya David Benioff Greg Berlanti, Marc Guggenheim, Andrew Kreisberg",
                kreator = "David Benioff, D. B. Weiss",
                score = "84"))

        tvShows.add(TvResponse(
                tvShowId = "t5",
                title = "Gotham",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9jbJLks2YTBv7HeahdfkeeIuYpc.jpg",
                date = "2014",
                genre = "Drama, Kejahatan, Sci-fi & Fantasy",
                description = "Semua orang tahu nama Komisaris Gordon. Dia adalah salah satu musuh terbesar dunia kejahatan, seorang pria yang reputasinya identik dengan hukum dan ketertiban. Tapi apa yang diketahui tentang kisah Gordon dan kenaikannya dari detektif pemula ke Komisaris Polisi? Apa yang diperlukan untuk menavigasi berbagai lapisan korupsi yang diam-diam memerintah Kota Gotham, tempat bertelurnya penjahat paling ikonik di dunia? Dan keadaan apa yang menciptakan mereka - persona yang lebih besar dari kehidupan yang akan menjadi Catwoman, The Penguin, The Riddler, Two-Face dan The Joker?",
                kreator = "Bruno Heller",
                score = "75"))

        tvShows.add(TvResponse(
                tvShowId = "t6",
                title = "Hanna",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/toQzJUE9VM3erjs1f5sn6Aa4deL.jpg",
                date = "2019",
                genre = "Aksi & Petualangan, Drama",
                description = "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                kreator = "David Farr",
                score = "75"))

        tvShows.add(TvResponse(
                tvShowId = "t7",
                title = "Iron Fish",
                image = "https://www.sanity.com.au/media/Images/fullimage/484582/SDC_1401408_2018-20-11--16-14-19.jpg",
                date = "2017",
                genre = "Aksi & Petualangan, Drama, Sci-fi & Fantasy",
                description = "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                kreator = "Scott Buck",
                score = "65"))

        tvShows.add(TvResponse(
                tvShowId = "t8",
                title = "Naruto Shippuden",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/3JGx8nRdsMWB6crJtIqRBteK5V3.jpg",
                date = "2007",
                genre = "Keluarga, Aksi, Animasi, Petualangan, Fantasi",
                description = "Naruto Shippuuden adalah kelanjutan dari serial TV animasi asli Naruto. Kisah ini berkisah tentang Uzumaki Naruto yang lebih tua dan sedikit lebih matang dan upayanya untuk menyelamatkan temannya Uchiha Sasuke dari cengkeraman Shinobi seperti ular, Orochimaru. Setelah 2 setengah tahun, Naruto akhirnya kembali ke desanya Konoha, dan mulai mewujudkan ambisinya, meskipun itu tidak akan mudah, karena Ia telah mengumpulkan beberapa musuh (lebih berbahaya), seperti organisasi shinobi. ; Akatsuki.",
                kreator = "Hajime Kamegaki",
                score = "84"))

        tvShows.add(TvResponse(
                tvShowId = "t9",
                title = "Super Girl",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/m25hItTmnC4l12hsKU1fNuo4Grc.jpg",
                date = "2015",
                genre = "Drama, Sci-fi & Fantasy, Aksi & Petualangan",
                description = "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                kreator = "Greg Berlanti, Ali Adler, Andrew Kreisberg",
                score = "72"))

        tvShows.add(TvResponse(
                tvShowId = "t10",
                title = "The Walking Dead",
                image = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                date = "2010",
                genre = "Aksi & Petualangan, Drama, Sci-fi & Fantasy",
                description = "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                kreator = "Frank Darabont",
                score = "80"))

        return tvShows
    }

    fun generateDummyDetailMovie(moviesEntity: MoviesEntity, favorite: Boolean) : MoviesEntity {
        moviesEntity.favorite = favorite
        return moviesEntity as MoviesEntity
    }

    fun generateDummyDetailTv(tvShowEntity: TvShowEntity, favorite: Boolean) : TvShowEntity {
        tvShowEntity.favorite = favorite
        return tvShowEntity as TvShowEntity
    }


}