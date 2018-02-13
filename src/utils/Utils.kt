package utils

import java.math.BigInteger

class Utils {

    class DataGenerator{

        companion object {
            fun getFibonachiList(): List<Int> {
                val fibo = ArrayList<Int>()
                fibo.add(1)
                fibo.add(2)
                fibo.add(3)
                fibo.add(5)
                fibo.add(8)
                fibo.add(13)
                fibo.add(21)
                fibo.add(34)
                return fibo
            }

            fun getFibonaciArray(): Array<Int> {
                return arrayOf(1, 2, 3, 5, 8, 13, 21, 34)
            }

            fun generateBigIntegerList(): List<Int> {
                val data = ArrayList<Int>()
                return (0..199).mapTo(data) { it }
            }


            fun provideEnglishAlphabet() : List<String>{
                val data = ArrayList<String>()
                return ('a'..'z').mapTo(data) { it.toString() }
            }

            fun provideEmptyList(): List<String>{
                return ArrayList<String>()
            }

            fun provideGreekAlphabet() : List<String>{
                val data = ArrayList<String>()

                data.add("Alpha")
                data.add("Bet")
                data.add("Gamma")
                data.add("Delta")
                data.add("Epsilon")
                data.add("Zeta")
                data.add("Eta")
                data.add("Theta")
                data.add("Iota")
                data.add("Kappa")
                data.add("Lambda")
                data.add("Mue")
                data.add("Nue")
                data.add("Xi")
                data.add("Omicron")
                data.add("Pi")
                data.add("Rho")
                data.add("Sigma")
                data.add("Tau")
                data.add("Upsilon")
                data.add("Phi")
                data.add("Chi")
                data.add("Psi")
                data.add("Omega")

                return data
            }
        }

    }
}