package ru.skillbranch.skillarticles.viewmodels

import androidx.lifecycle.SavedStateHandle
import ru.skillbranch.skillarticles.R
import ru.skillbranch.skillarticles.data.repositories.RootRepository
import ru.skillbranch.skillarticles.viewmodels.base.BaseViewModel
import ru.skillbranch.skillarticles.viewmodels.base.IViewModelState
import ru.skillbranch.skillarticles.viewmodels.base.NavigationCommand

/**
 * Created on 09.05.2020.
 *
 * @author Alexander Tavtorkin (av.tavtorkin@gmail.com)
 */
class RootViewModel(handle: SavedStateHandle) : BaseViewModel<RootState>(handle, RootState()) {
    private val repository: RootRepository = RootRepository
    private val privateRoutes = listOf(R.id.nav_profile)

    init {
        subscribeOnDataSource(repository.isAuth()) { isAuth, state ->
            state.copy(isAuth = isAuth)
        }
    }

    override fun navigate(command: NavigationCommand) {
        when (command) {
            is NavigationCommand.To -> {
                if (privateRoutes.contains(command.description) && !currentState.isAuth) {
                    //set requested destination as args
                    super.navigate(NavigationCommand.StartLogin(command.description))
                } else {
                    super.navigate(command)
                }
            }
            else -> super.navigate(command)
        }
    }
}

data class RootState(
    val isAuth: Boolean = false
) : IViewModelState