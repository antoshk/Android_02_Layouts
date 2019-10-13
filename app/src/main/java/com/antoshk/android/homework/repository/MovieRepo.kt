package com.antoshk.android.homework.repository

object MovieRepo {

    val movies: List<Movie> = generateMovies()

    private fun generateMovies(): List<Movie> {
        val result = mutableListOf<Movie>()
        result.add(
            Movie(
                "Jurassic World",
                "https://image.tmdb.org/t/p/w342/c9XxwwhPHdaImA2f1WEfEsbhaFB.jpg",
                "https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Fjeffewing%2Ffiles%2F2018%2F06%2Fjurassic_world_fallen_kingdom.jpg",
                "A new theme park, built on the original site of Jurassic Park, creates a genetically modified hybrid dinosaur, the Indominus Rex, which escapes containment and goes on a killing spree.",
                "June 22, 2018",
                "https://youtu.be/vn9mMeWcgoM"
            )
        )
        result.add(
            Movie(
                "The Meg",
                "https://image.tmdb.org/t/p/w342/eyWICPcxOuTcDDDbTMOZawoOn8d.jpg",
                "https://www.slashfilm.com/wp/wp-content/images/the-meg-2-1.jpg",
                "A group of scientists exploring the Marianas Trench encounter the largest marine predator that has ever existed - the Megalodon.",
                "August 10, 2018",
                "https://youtu.be/GGYXExfKhmo"
            )
        )
        result.add(
            Movie(
                "The First Purge",
                "https://image.tmdb.org/t/p/w342/2slvblTroiT1lY9bYLK7Amigo1k.jpg",
                "https://i2.wp.com/splashreport.com/wp-content/uploads/2018/03/the-purge-election-year.jpg?fit=800%2C445",
                "America's third political party, the New Founding Fathers of America, comes to power and conducts an experiment: no laws for 12 hours on Staten Island. No one has to stay on the island, but \$5,000 is given to anyone who does.",
                "July 4, 2018",
                "https://youtu.be/UL29y0ah92w"
            )
        )
        result.add(
            Movie(
                "Deadpool 2",
                "https://image.tmdb.org/t/p/w342/to0spRl1CMDvyUbOnbb4fTk3VAd.jpg",
                "https://www.foxmovies.com/s3/dev-temp/en-US/__5b3f9f284b674.jpg",
                "Foul-mouthed mutant mercenary Wade Wilson (a.k.a. Deadpool), brings together a team of fellow mutant rogues to protect a young boy with supernatural abilities from the brutal, time-traveling cyborg Cable.",
                "May 18, 2018",
                "https://youtu.be/20bpjtCbCz0"
            )
        )
        result.add(
            Movie(
                "Black Panther",
                "https://image.tmdb.org/t/p/w342/uxzzxijgPIY7slzFvMotPv8wjKA.jpg",
                "https://longreadsblog.files.wordpress.com/2018/02/black-panther.jpg?w=1680",
                "T'Challa, heir to the hidden but advanced kingdom of Wakanda, must step forward to lead his people into a new future and must confront a challenger from his country's past.",
                "February 16, 2018",
                "https://youtu.be/xjDjIWPwcPU"
            )
        )
        result.add(
            Movie(
                "Ocean's Eight",
                "https://image.tmdb.org/t/p/w342/MvYpKlpFukTivnlBhizGbkAe3v.jpg",
                "https://ksassets.timeincuk.net/wp/uploads/sites/55/2017/12/Oceans-8-poster.png",
                "Debbie Ocean gathers an all-female crew to attempt an impossible heist at New York City's yearly Met Gala.",
                "June 8, 2018",
                "https://youtu.be/MFWF9dU5Zc0"
            )
        )
        result.add(
            Movie(
                "Interstellar",
                "https://image.tmdb.org/t/p/w342/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg",
                "https://www.syfy.com/sites/syfy/files/styles/1200x680/public/wire/legacy/interstellar_holy_shit_shot.0.png",
                "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                "November 7, 2014",
                "https://youtu.be/zSWdZVtXT7E"
            )
        )
        result.add(
            Movie(
                "Thor - Ragnarok",
                "https://image.tmdb.org/t/p/w342/rzRwTcFvttcN1ZpX2xv4j3tSdJu.jpg",
                "https://thumbor.forbes.com/thumbor/960x0/https%3A%2F%2Fblogs-images.forbes.com%2Frobcain%2Ffiles%2F2017%2F10%2FThor-Ragnarok-2.jpg",
                "Thor (Chris Hemsworth) is imprisoned on the planet Sakaar, and must race against time to return to Asgard and stop Ragnarök, the destruction of his world, at the hands of the powerful and ruthless villain Hela (Cate Blanchett).",
                "November 3, 2017",
                "https://youtu.be/ue80QwXMRHg"
            )
        )
        result.add(
            Movie(
                "Guardians of the Galaxy",
                "https://image.tmdb.org/t/p/w342/y31QB9kn3XSudA15tV7UWQ9XLuW.jpg",
                "https://www.slashfilm.com/wp/wp-content/images/endgame-sets-up-guardians-of-the-galaxy-vol.-3.jpg",
                "A group of intergalactic criminals must pull together to stop a fanatical warrior with plans to purge the universe.",
                "August 1, 2014",
                "https://youtu.be/d96cjJhvlMA"
            )
        )

        return result
    }
}