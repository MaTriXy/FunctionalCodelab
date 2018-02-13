import rx.Observable
import rx.Observer
import rx.schedulers.Schedulers
import service.User
import service.UserService

fun main(args: Array<String>) {



        val userService = UserService()


        Observable.from(userService.fetchAllUsers())
                .subscribeOn(Schedulers.io())
                .doOnCompleted {

                }.subscribe(object : Observer<User> {
            override fun onNext(p0: User) {
                System.out.println(p0)
            }

            override fun onError(p0: Throwable) {
                System.out.println("onError")
            }

            override fun onCompleted() {
                System.out.println("onComplete")
            }

        })
    }
