package es.jfechevarria.application.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import es.jfechevarria.application.core.BaseAdapter
import es.jfechevarria.application.core.BasePagingAdapter
import es.jfechevarria.application.databinding.ItemUserBinding
import es.jfechevarria.application.ui.viewHolders.UserViewHolder
import es.jfechevarria.domain.user.User

class UserAdapter: BasePagingAdapter<User, UserViewHolder>(object: DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.userName == newItem.userName
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.userName == newItem.userName
    }

}) {
    override fun createViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        return UserViewHolder(ItemUserBinding.inflate(inflater, parent, false))
    }
}