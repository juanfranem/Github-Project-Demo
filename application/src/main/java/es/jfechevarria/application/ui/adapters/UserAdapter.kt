package es.jfechevarria.application.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import es.jfechevarria.application.core.BasePagingAdapter
import es.jfechevarria.application.databinding.ItemUserBinding
import es.jfechevarria.application.ui.interfaces.UserInteractor
import es.jfechevarria.application.ui.viewHolders.UserViewHolder
import es.jfechevarria.domain.user.User

class UserAdapter(
    private val userInteractor: UserInteractor
): BasePagingAdapter<User, UserViewHolder>(object: DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

}) {
    override fun createViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        return UserViewHolder(userInteractor, ItemUserBinding.inflate(inflater, parent, false))
    }
}